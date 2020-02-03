package ru.jenny.simplews

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.jenny.simplews.repository.ProjectRepository
import ru.jenny.simplews.repository.dao.EventType
import ru.jenny.simplews.rest.dto.DeviceDto
import ru.jenny.simplews.rest.dto.ProjectDto
import ru.jenny.simplews.rest.dto.ProjectStat
import ru.jenny.simplews.rest.dto.SummaryInfo
import java.time.LocalDateTime
import javax.annotation.PostConstruct

@RestController
class ApiController {

    @Autowired
    lateinit var projectsRepository: ProjectRepository

    @GetMapping("/projects")
    fun getProjects(): List<ProjectDto> {

        val response: MutableList<ProjectDto> = mutableListOf()

        val projects = projectsRepository.findAll()
        val currentLocalDateTime = LocalDateTime.now()
        val beginOfDay = LocalDateTime.of(currentLocalDateTime.year, currentLocalDateTime.month, currentLocalDateTime.dayOfMonth, 0, 0)

        for (project in projects) {

            val devicesSerialNumber = project.devices.map {
                it.serialNumber
            }

            var deviceCount = 0
            var deviceWithError = 0
            var stableDevices = 0

            for (device in project.devices) {
                deviceCount++
                if (device.events.any {
                            (it.type == EventType.ERROR ||
                                    it.type == EventType.WARNING) &&
                                    it.date > beginOfDay
                        }) {
                    deviceWithError++
                } else {
                    if (device.events.all {
                                it.type == EventType.EVENT
                            }) {
                        stableDevices++
                    }
                }
            }

            response.add(ProjectDto(project.id, project.name, ProjectStat(deviceCount, deviceWithError, stableDevices), devicesSerialNumber))
        }

        return response

    }

    @GetMapping("/devices")
    fun getDevices(@RequestParam(name = "id") projectId: Long?): Map<String, DeviceDto> {

        if (projectId == null) {
            return mapOf()
        }

        val response = HashMap<String, DeviceDto>()

        val project = projectsRepository.findById(projectId).orElse(null) ?: return mapOf()

        for (device in project.devices) {
            val hasError = device.events.any {
                it.type == EventType.ERROR
            }

            val eventCount = device.events.count()

            val warningCount = device.events.filter {
                it.type == EventType.WARNING
            }.count()

            val errorCount = device.events.filter {
                it.type == EventType.ERROR
            }.count()

            response[device.serialNumber] = DeviceDto(device.id, device.serialNumber, projectId, hasError, SummaryInfo(eventCount, warningCount, errorCount))
        }

        return response


    }

    @PostConstruct
    fun postConstruct() {
        println("ApiController initialized")
    }

}
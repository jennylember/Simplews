package ru.jenny.simplews

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.jenny.simplews.repository.DeviceRepository
import ru.jenny.simplews.repository.EventRepository
import ru.jenny.simplews.rest.dto.Device
import ru.jenny.simplews.rest.dto.Project
import ru.jenny.simplews.rest.dto.ProjectStat
import ru.jenny.simplews.rest.dto.SummaryInfo
import javax.annotation.PostConstruct

@RestController
class ApiController {

    @Autowired
    lateinit var eventsRepository: EventRepository

    @Autowired
    lateinit var devicesRepository: DeviceRepository

    @GetMapping("/projects")
    fun getProjects(): List<Project> {

        val summaryInfo1 = SummaryInfo(10, 2, 0)
        val summaryInfo2 = SummaryInfo(20, 7, 5)
        val summaryInfo3 = SummaryInfo(30, 5, 2)
        val summaryInfo4 = SummaryInfo(40, 0, 3)
        val summaryInfo5 = SummaryInfo(50, 2, 9)

        val device1 = Device(1, "A1", 1, false, summaryInfo1)
        val device2 = Device(1, "A2", 1, false, summaryInfo2)
        val device3 = Device(1, "A3", 1, false, summaryInfo3)
        val device4 = Device(1, "A4", 2, true, summaryInfo4)
        val device5 = Device(1, "A5", 2, false, summaryInfo5)

//        val deviceList1 = ArrayList<Device>()
//        deviceList1.add(device1)
//        deviceList1.add(device2)
//        deviceList1.add(device3)

        val deviceList2 = ArrayList<Device>()
        deviceList2.add(device4)
        deviceList2.add(device5)

        val stat1 = ProjectStat(10, 5, 5)
        val stat2 = ProjectStat(1000, 0, 1000)

        val project1 = Project(1, "First Project", stat1, listOf(device1.serialNumber, device2.serialNumber, device3.serialNumber))
        val project2 = Project(2, "Second Project", stat2, listOf(device4.serialNumber, device5.serialNumber))

        val projects = ArrayList<Project>()
        projects.add(project1)
        projects.add(project2)

        return projects

    }

    @GetMapping("/devices")
    fun getDevices(@RequestParam(name = "id") projectId: Long?): Map<String, Device> {
        val summaryInfo1 = SummaryInfo(10, 2, 0)
        val summaryInfo2 = SummaryInfo(20, 7, 5)
        val summaryInfo3 = SummaryInfo(30, 5, 2)
        val summaryInfo4 = SummaryInfo(40, 0, 3)
        val summaryInfo5 = SummaryInfo(50, 2, 9)

        val device1 = Device(1, "A1", 1, false, summaryInfo1)
        val device2 = Device(1, "A2", 1, false, summaryInfo2)
        val device3 = Device(1, "A3", 1, false, summaryInfo3)
        val device4 = Device(1, "A4", 2, true, summaryInfo4)
        val device5 = Device(1, "A5", 2, false, summaryInfo5)

        val deviceList1 = ArrayList<Device>()
        deviceList1.add(device1)
        deviceList1.add(device2)
        deviceList1.add(device3)

        val deviceList2 = ArrayList<Device>()
        deviceList2.add(device4)
        deviceList2.add(device5)

        val map = HashMap<String, Device>()


        map[device1.serialNumber] = device1
        map[device2.serialNumber] = device2
        map[device3.serialNumber] = device3


        return map


    }

    @PostConstruct
    fun postConstruct() {
        val string = "String"
    }

}
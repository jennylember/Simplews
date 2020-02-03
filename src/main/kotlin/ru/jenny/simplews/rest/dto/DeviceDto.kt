package ru.jenny.simplews.rest.dto

class DeviceDto(val id: Long, val serialNumber: String, val projectId: Long, val hasErrors: Boolean, val summaryInfo: SummaryInfo) {

}
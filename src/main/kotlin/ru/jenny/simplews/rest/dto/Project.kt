package ru.jenny.simplews.rest.dto

class Project(val id: Long, val projectName: String, val stats: ProjectStat, val devices: List<String>) {

}
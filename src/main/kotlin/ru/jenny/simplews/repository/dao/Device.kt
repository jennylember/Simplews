package ru.jenny.simplews.repository.dao

import javax.persistence.*

@Entity
@Table(name = "devices")
class Device(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
             @Column(name = "project_id") val projectId: Long,
             @Column(name = "serial_number") val serialNumber: String) {

    @OneToMany(mappedBy = "devices", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val events = mutableListOf<Event>()
}
package ru.jenny.simplews.repository.dao

import javax.persistence.*


@Entity
@Table(name = "devices")
class Device(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column(name = "serial_number")
        val serialNumber: String) {

    @OneToMany(fetch = FetchType.EAGER, cascade = [(CascadeType.ALL)], mappedBy = "device")
    val events = mutableListOf<Event>()

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    val project: Project? = null

}
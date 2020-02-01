package ru.jenny.simplews.repository.dao

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "events")
data class Event(

        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
//
//        @Column(name = "device_id")
//        val deviceId: Long = -1,

        @Column(name = "date")
        val date: LocalDateTime,

        @Enumerated(EnumType.STRING)
        @Column(name = "type") val type: EventType,

        @Column(name = "is_read")
        val isRead: Boolean,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "device_id")
        val device: Device? = null
        ) {
}
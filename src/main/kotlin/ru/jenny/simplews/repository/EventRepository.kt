package ru.jenny.simplews.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.jenny.simplews.repository.dao.Event
import ru.jenny.simplews.rest.dto.Device

@Repository
interface EventRepository: JpaRepository<Event, Long>
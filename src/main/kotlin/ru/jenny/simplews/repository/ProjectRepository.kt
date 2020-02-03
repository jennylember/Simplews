package ru.jenny.simplews.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.jenny.simplews.repository.dao.Project


@Repository
interface ProjectRepository : JpaRepository<Project, Long>
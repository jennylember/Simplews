package ru.jenny.simplews.repository.dao

import javax.persistence.*

//@Entity
@Table(name = "projects")
class Project(@Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long,
              @Column(name = "Name") val name: String) {


//    @OneToMany(mappedBy = "projects")
//    val devices: Set<Device> = HashSet<Device>()

}
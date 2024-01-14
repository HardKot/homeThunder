package com.homeThunder.repository.dao

import com.homeThunder.repository.baseEntity.BaseEntity
import com.homeThunder.repository.baseEntity.BaseEntityClass
import com.homeThunder.repository.tables.OrganizationTable
import org.jetbrains.exposed.dao.id.EntityID
import java.util.*
import javax.inject.Inject

class OrganizationDAO @Inject constructor(id: EntityID<UUID>) : BaseEntity(id, OrganizationTable) {
    companion object : BaseEntityClass<OrganizationDAO>(OrganizationTable)

    var name by OrganizationTable.name
    var email by OrganizationTable.email
    var phone by OrganizationTable.phone
    val short by OrganizationTable.short

    var avatarId by OrganizationTable.avatarId
    val additionalContact by OrganizationTable.additionalContact
}

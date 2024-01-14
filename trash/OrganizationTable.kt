package com.homeThunder.repository.tables

import com.homeThunder.data.entity.Organization
import com.homeThunder.repository.baseEntity.BaseEntityTable
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.json.json

object OrganizationTable : BaseEntityTable("Organization") {
    val name = varchar("firstname", 255)
    val short = varchar("firstname", 10)
    val phone = varchar("phone", 255).nullable()
    val email = varchar("email", 255).uniqueIndex()
    val additionalContact = json<Array<Organization.AdditionalContact>>("additionalContact", Json.Default).default(arrayOf())
    val avatarId = uuid("avatarId").nullable()
}

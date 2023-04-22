package com.example.shared.config

import org.mapstruct.Builder
import org.mapstruct.InjectionStrategy
import org.mapstruct.MapperConfig
import org.mapstruct.ReportingPolicy
import java.util.UUID

@MapperConfig(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR,
    implementationPackage = "<PACKAGE_NAME>.impl",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    builder = Builder(disableBuilder = true),
    imports = [UUID::class]
)
interface MapperConfig
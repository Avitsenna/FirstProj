package ru.back.backend.mapper;

public interface ModelMapper<Model, DTO>{
    // из Model'и
    DTO toDto(Model model);
    // из DTO в Model(на всякий случай)
    Model toModel(DTO dto);
}
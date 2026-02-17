package dev.java10x.desafiorelogio.dto;

import java.util.List;

public record PaginaRelogiosDto(
        List<RelogioDto> itens,
        long total
) {}
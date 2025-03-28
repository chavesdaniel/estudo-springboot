package br.com.marujaum.marujaum_api.domain.event;

public record CouponRequestDTO(String code, Integer discount, Long valid) {
}

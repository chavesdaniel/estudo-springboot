package br.com.marujaum.marujaum_api.domain.event;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public record EventDetailsDTO(UUID id,
                              String title,
                              String description,
                              Date date,
                              String city,
                              String state,
                              String imageUrl,
                              String eventUrl,
                              List<CouponDTO> couponDTOs) {

    public record CouponDTO(
            String code,
            Integer discount,
            Date validUntil
    ){}
}

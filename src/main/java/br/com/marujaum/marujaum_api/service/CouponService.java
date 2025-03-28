package br.com.marujaum.marujaum_api.service;

import br.com.marujaum.marujaum_api.domain.coupon.Coupon;
import br.com.marujaum.marujaum_api.domain.event.CouponRequestDTO;
import br.com.marujaum.marujaum_api.domain.event.Event;
import br.com.marujaum.marujaum_api.repositories.CouponRepository;
import br.com.marujaum.marujaum_api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCouponToEvent(UUID eventId, CouponRequestDTO data) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(data.code());
        coupon.setDiscount(data.discount());
        coupon.setValid(new Date(data.valid()));
        coupon.setEvent(event);

        couponRepository.save(coupon);

        return coupon;
    }

    public List<Coupon> consultCoupons(UUID eventId, Date currentDate) {
        return couponRepository.findByEventIdAndValidAfter(eventId, currentDate);
    }
}

package org.example.service.offer;

import org.example.base.service.BaseServiceImpl;
import org.example.model.Offer;
import org.example.repository.offer.OfferRepository;
import org.hibernate.SessionFactory;

public class OfferServiceImpl extends BaseServiceImpl<Offer, Long, OfferRepository>
        implements OfferService {
    public OfferServiceImpl(OfferRepository repository, SessionFactory sessionFactory) {
        super(repository, sessionFactory);
    }
}

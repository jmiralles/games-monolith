package org.lordofthejars.games.reviews.impl;

import org.lordofthejars.games.reviews.api.Review;
import org.lordofthejars.games.reviews.api.ReviewService;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
class ReviewServiceImpl implements ReviewService {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public List<Review> findReviewsByGameId(long gameId) {
    return entityManager.createNamedQuery("Review.FindReviewsByGameId", Review.class)
        .setParameter("gameId", gameId)
        .getResultList();
  }
}

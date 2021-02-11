package services.interfaces;

import models.Club;
import models.User;

import java.util.List;

public interface ClubService {
    boolean insert(Club entity);

    boolean update(Club entity);

    boolean remove(long id);

    Club select(long id);

    List<Club> getClubList();

    boolean addUserToClub(long userId, long clubId);

    boolean removeUserFromClub(long userId, long clubId);

    List<User> getMembersByClubId(long clubId);

    List<User> getMembershipRequestsByClubId(long clubId);

    boolean removeUserRequestsToJoinTheClub(long userId, long clubId);

    boolean addUserRequestsToJoinTheClub(long userId, long clubId);

    User getClubOwnerByClubId(long clubId);
}

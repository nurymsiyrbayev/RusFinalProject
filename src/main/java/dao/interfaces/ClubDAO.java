package dao.interfaces;

import models.Club;
import models.User;

import java.util.List;

public interface ClubDAO extends DAO<Club> {
    List<Club> getClubList();

    boolean addUserToClub(long userId, long clubId);

    boolean removeUserFromClub(long userId, long clubId);

    List<User> getMembersByClubId(long clubId);

    List<User> getMembershipRequestsByClubId(long clubId);

    boolean removeUserRequestsToJoinTheClub(long userId, long clubId);

    boolean addUserRequestsToJoinTheClub(long userId, long clubId);

    User getClubOwnerByClubId(long clubId);
}

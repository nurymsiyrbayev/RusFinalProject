package services;

import dao.ClubDAOImpl;
import dao.interfaces.ClubDAO;
import models.Club;
import models.User;
import services.interfaces.ClubService;

import java.util.List;

public class ClubServiceImpl implements ClubService {
    private ClubDAO clubDAO = new ClubDAOImpl();

    @Override
    public boolean insert(Club entity) {
        return clubDAO.insert(entity);
    }

    @Override
    public boolean update(Club entity) {
        return clubDAO.update(entity);
    }

    @Override
    public boolean remove(long id) {
        return clubDAO.remove(id);
    }

    @Override
    public Club select(long id) {
        return clubDAO.select(id);
    }

    @Override
    public List<Club> getClubList() {
        return clubDAO.getClubList();
    }

    @Override
    public boolean addUserToClub(long userId, long clubId) {
        return clubDAO.addUserToClub(userId, clubId);
    }

    @Override
    public boolean removeUserFromClub(long userId, long clubId) {
        return clubDAO.removeUserFromClub(userId, clubId);
    }

    @Override
    public List<User> getMembersByClubId(long clubId) {
        return clubDAO.getMembersByClubId(clubId);
    }

    @Override
    public List<User> getMembershipRequestsByClubId(long clubId) {
        return clubDAO.getMembershipRequestsByClubId(clubId);
    }

    @Override
    public boolean removeUserRequestsToJoinTheClub(long userId, long clubId) {
        return clubDAO.removeUserRequestsToJoinTheClub(userId, clubId);
    }

    @Override
    public boolean addUserRequestsToJoinTheClub(long userId, long clubId) {
        return clubDAO.addUserRequestsToJoinTheClub(userId,clubId);
    }

    @Override
    public User getClubOwnerByClubId(long clubId) {
        return clubDAO.getClubOwnerByClubId(clubId);
    }
}

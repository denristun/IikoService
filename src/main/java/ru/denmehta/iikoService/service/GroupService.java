package ru.denmehta.iikoService.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.GroupRepository;

import java.util.List;


@Service
public class GroupService implements IBaseDbService<Group, String> {

    final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public String getName() {
        return Group.class.getName();
    }

    @Override
    public JpaRepository<Group, String> getRepository() {
        return groupRepository;
    }

    public List<Group> getAllSiteDisplayedAndSite(Site site) {
        return groupRepository.findByIsSiteDisplayAndSite(true, site);
    }
}

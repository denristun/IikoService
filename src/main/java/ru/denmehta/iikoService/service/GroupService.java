package ru.denmehta.iikoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.GroupRepository;

import java.util.List;
import java.util.Optional;


@Service
    public class GroupService   {

        final
        GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    public Group getById(String id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return optionalGroup.get();
        }
        return null;
    }

    public void save(Group group) {
    }

    public void delete(String id) {

    }

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public List<Group> getAllSiteDisplayedAndSite(Site site) {
        return groupRepository.findByIsSiteDisplayAndSite(true, site);
    }
}

package ru.denmehta.iikoService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.denmehta.iikoService.models.Group;
import ru.denmehta.iikoService.models.Site;
import ru.denmehta.iikoService.repository.GroupRepository;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
    public class GroupService implements GroupServiceInterface  {

        final
        GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }


    @Override
    public Group getById(String id) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isPresent()) {
            return optionalGroup.get();
        }
        return null;
    }

    @Override
    public void save(Group group) {
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> getAllSiteDisplayedAndSite(Site site) {
        return groupRepository.findByIsSiteDisplayAndSite(true, site);
    }
}

package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CandidatesService {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContributionRepository contribRepository;

    public Iterable<Person> collectCandidates(
            Integer projectId,
            boolean checkProjectMembership,
            boolean checkCompanyMembership,
            boolean checkSkills,
            boolean noTargetProjectContrib) {
        var project = projectService.get(projectId).get();
        return collectCandidates(
                List.of(project.getCompany()),
                project.getTechnologies(),
                project,
                checkProjectMembership,
                checkCompanyMembership,
                checkSkills,
                noTargetProjectContrib);
    }

    public Iterable<Person> collectCandidates(
            Collection<Company> membership,
            Collection<Technology> techRequirements,
            Project targetProject,
            boolean checkProjectMembership,
            boolean checkCompanyMembership,
            boolean checkSkills,
            boolean noTargetProjectContrib) {

        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .filter(person -> !checkProjectMembership
                        || targetProject == null
                        || !targetProject.getPeople().contains(person))
                .filter(person -> !checkCompanyMembership
                        || person.getMembership().containsAll(membership))
                .filter(person -> !checkSkills
                        || person.getSkills().containsAll(techRequirements))
                .filter(person -> !noTargetProjectContrib
                        || targetProject == null
                        || contribRepository.countByPersonAndProject(
                                person.getId(),
                                targetProject.getId()) == 0)
                .collect(Collectors.toList());
    }
}

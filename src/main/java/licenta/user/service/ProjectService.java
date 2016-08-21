package licenta.user.service;

import licenta.user.entity.EmployeeProject;
import licenta.user.entity.Project;
import licenta.user.mapper.ProjectMapper;
import licenta.user.model.ProjectIdNameModel;
import licenta.user.model.ProjectModel;
import licenta.user.repository.EmployeeProjectRepository;
import licenta.user.repository.ProjectRepository;
import licenta.user.util.Auth;
import licenta.user.util.ProjectStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariana on 01.06.2016.
 */
@Service
@Transactional
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public ProjectModel getProjectModel(Long id) throws Exception{
        Project project = projectRepository.findOne(id);

        return ProjectMapper.toProjectModel(project);
    }

    public ProjectModel findProject(Long id) throws Exception{
        return ProjectMapper.toProjectModel(projectRepository.findOne(id));
    }

    public Page<Project> getProjectList(PageRequest pageRequest){
        Page<Project> projectList = projectRepository.findAll(pageRequest);

        return projectList;
    }

    public List<ProjectIdNameModel> getNotEndedProjectIdNameList(){
        List<Project> projectList = projectRepository.findByStatusNot(ProjectStatus.ENDED);
        List<ProjectIdNameModel> projectModelList = new ArrayList<>();

        for(Project project : projectList){
            ProjectIdNameModel model = new ProjectIdNameModel(project.getId(), project.getName());
            projectModelList.add(model);
        }

        return projectModelList;
    }

    public List<ProjectIdNameModel> findUserProjects(){
        List<EmployeeProject> employeeProjectList = employeeProjectRepository.findByEmployeeUserUsernameAndStatusTrue(Auth.userLoggedIn());
        List<ProjectIdNameModel> projectModelList = new ArrayList<>();

        for(EmployeeProject employeeProject : employeeProjectList){
            ProjectIdNameModel model = new ProjectIdNameModel(employeeProject.getProject().getId(),
                    employeeProject.getProject().getName());
            projectModelList.add(model);
        }

        return projectModelList;
    }
}

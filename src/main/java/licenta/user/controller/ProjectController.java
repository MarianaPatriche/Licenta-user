package licenta.user.controller;

import licenta.user.entity.Specification;
import licenta.user.repository.SpecificationRepository;
import licenta.user.service.AllocationService;
import licenta.user.service.ProjectService;
import licenta.user.util.Priority;
import licenta.user.util.SpecificationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mariana on 01.06.2016.
 */

@Controller
@RequestMapping("/project")
public class ProjectController extends BaseController{

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SpecificationRepository specificationRepository;

    @Autowired
    private AllocationService allocationService;

    @RequestMapping(value = "/list")
    public String projectList(Model model, @RequestParam(value = "page", required = true, defaultValue = "0") int page,
                              @RequestParam(value = "size", required = true, defaultValue = "5") int size){
        model.addAttribute("page", projectService.getProjectList(new PageRequest(page, size)));
        return "project/list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String projectDetail(@PathVariable("id") Long id , Model model) throws  Exception{
        model.addAttribute("project", projectService.getProjectModel(id));
        model.addAttribute("actualTeam", allocationService.getTeamByProject(id, Boolean.TRUE));
        model.addAttribute("oldTeam", allocationService.getTeamByProject(id, Boolean.FALSE));
        model.addAttribute("taskHigh", specificationRepository.findByPriorityAndProjectId(Priority.Ridicata, id));
        model.addAttribute("taskMedium", specificationRepository.findByPriorityAndProjectId(Priority.Medie, id));
        model.addAttribute("taskLow", specificationRepository.findByPriorityAndProjectId(Priority.Scazuta, id));

        return "project/detail";
    }

    @RequestMapping(value = "/specification/inprogress/{taskId}")
    public String specificationInProgress(@PathVariable("taskId") Long id){
        Specification specification = specificationRepository.findOne(id);

        specification.setStatus(SpecificationStatus.Inceput);
        specificationRepository.save(specification);

        return "redirect:/project/detail/" + specification.getProject().getId();
    }

    @RequestMapping(value = "/specification/done/{taskId}")
    public String specificationDone(@PathVariable("taskId") Long id){
        Specification specification = specificationRepository.findOne(id);

        specification.setStatus(SpecificationStatus.Terminat);
        specificationRepository.save(specification);

        return "redirect:/project/detail/" + specification.getProject().getId();
    }
}
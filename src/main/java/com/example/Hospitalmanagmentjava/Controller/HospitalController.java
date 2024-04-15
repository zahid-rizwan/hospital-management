package com.example.Hospitalmanagmentjava.Controller;

import com.example.Hospitalmanagmentjava.Model.AppointmentModel;
import com.example.Hospitalmanagmentjava.Model.DoctorModel;
import com.example.Hospitalmanagmentjava.Model.PatientModel;
import com.example.Hospitalmanagmentjava.Repository.AppointmentRepo;
import com.example.Hospitalmanagmentjava.Repository.DoctorRepo;
import com.example.Hospitalmanagmentjava.Repository.PatientRepo;
import com.example.Hospitalmanagmentjava.Service.AppointmentService;
import com.example.Hospitalmanagmentjava.Service.DoctorService;
import com.example.Hospitalmanagmentjava.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
public class HospitalController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorRepo doctorRepo;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @RequestMapping(path="/",method = RequestMethod.GET)
    public String home(Model m){
        List<DoctorModel> doc=doctorService.getdoctor();
        List<PatientModel> pat=patientService.getPatient();
        List<AppointmentModel> app=appointmentService.getappointment();
        long dc=0;
        long pc=0;
        long ac=0;
        dc=doc.stream().count();
        pc=pat.stream().count();
        ac=app.stream().count();
        m.addAttribute("pcount",pc);
        m.addAttribute("dcount",dc);
        m.addAttribute("acount",ac);
        return "index";
    }

    @RequestMapping(path="/adddoctor",method = RequestMethod.GET)
    public String viewDoctor(){
        return "Add_Doctor";
    }

    @RequestMapping(path="/addDoctor",method = RequestMethod.POST)
    public String doctorRegister(DoctorModel e, Model m, HttpSession session){
        doctorService.addDoctor(e);
        session.setAttribute("msg","Doctor Added Successfully..");
        return "redirect:/view_doctor";
    }
    @RequestMapping(path="/view_doctor",method = RequestMethod.GET)
    public String getDoctor(Model m){
        List<DoctorModel> doc=doctorService.getdoctor();
        long c=0;
        c=doc.stream().count();
        m.addAttribute("doc",doc);
        m.addAttribute("co",c);

        return "view_Doctor";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        DoctorModel user = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_doctor";
    }
    @RequestMapping(path = "/update_Doctor/{id}",method = RequestMethod.POST)
    public String updateDoctor(@PathVariable("id") int id, DoctorModel d, BindingResult result,Model m,HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_doctor";
        }
        doctorService.addDoctor(d);
        session.setAttribute("msg","Doctor Updated Successfully..");
        return "redirect:/view_doctor";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        DoctorModel user = doctorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        doctorRepo.delete(user);
        return "redirect:/view_doctor";
    }


    @RequestMapping(path="/addpatient",method = RequestMethod.GET)
    public String viewPatient(){
        return "Add_Patient";
    }

    @RequestMapping(path="/addPatient",method = RequestMethod.POST)
    public String patientRegister(PatientModel e, Model m, HttpSession session){
        patientService.addPatient(e);
        session.setAttribute("msg","Patient Added Successfully..");
        return "redirect:/view_patient";
    }
    @RequestMapping(path="/view_patient",method = RequestMethod.GET)
    public String getPatient(Model m){
        List<PatientModel> pat=patientService.getPatient();
        m.addAttribute("pat",pat);
        return "view_Patient";
    }
    @GetMapping("/edit_patient/{id}")
    public String showUpdateFormPatient(@PathVariable("id") int id, Model model) {
        PatientModel user = patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_patient";
    }
    @RequestMapping(path = "/update_Patient/{id}",method = RequestMethod.POST)
    public String updatePatient(@PathVariable("id") int id, PatientModel d, BindingResult result,Model m,HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_patient";
        }
        patientService.addPatient(d);
        session.setAttribute("msg","Patient Updated Successfully..");
        return "redirect:/view_patient";
    }
    @GetMapping("/delete_patient/{id}")
    public String deletePatient(@PathVariable("id") int id, Model model) {
        PatientModel user = patientRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        patientRepo.delete(user);
        return "redirect:/view_patient";
    }

    @RequestMapping(path="/addappointment",method = RequestMethod.GET)
    public String viewAppointment(Model m){
        List<DoctorModel> doc=doctorService.getdoctor();
        List<PatientModel> pat=patientService.getPatient();
        m.addAttribute("pat",pat);
        m.addAttribute("doc",doc);
        return "Add_Appointment";
    }

    @RequestMapping(path="/addAppointment",method = RequestMethod.POST)
    public String appointmentRegister(AppointmentModel e, Model m, HttpSession session){
        appointmentService.addAppointment(e);
        session.setAttribute("msg","Appointment Added Successfully..");
        return "redirect:/view_appointment";
    }
    @RequestMapping(path="/view_appointment",method = RequestMethod.GET)
    public String getAppointment(Model m){
        List<AppointmentModel> pat=appointmentService.getappointment();
        m.addAttribute("pat",pat);
        return "view_appointment";
    }
    @GetMapping("/edit_appointment/{id}")
    public String showUpdateFormAppointment(@PathVariable("id") int id, Model model) {
        AppointmentModel user = appointmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_appointment";
    }
    @RequestMapping(path = "/update_Appointment/{id}",method = RequestMethod.POST)
    public String updateAppointment(@PathVariable("id") int id, AppointmentModel d, BindingResult result,Model m,HttpSession session){
        if(result.hasErrors()){
            d.setId(id);
            return "update_appointment";
        }
        appointmentService.addAppointment(d);
        session.setAttribute("msg","Appointment Updated Successfully..");
        return "redirect:/view_appointment";
    }
    @RequestMapping(path = "/update_appointment_value/{id}",method = RequestMethod.GET)
    public ResponseEntity<List<AppointmentModel>> updateAppointmentvalue(@PathVariable("id") int id, AppointmentModel d, BindingResult result, Model m, HttpSession session){
        return ResponseEntity.ok().body(appointmentRepo.findAllById(Collections.singleton(id)));
    }

    @GetMapping("/delete_appointment/{id}")
    public String deleteAppointment(@PathVariable("id") int id, Model model) {
        AppointmentModel user = appointmentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        appointmentRepo.delete(user);
        return "redirect:/view_appointment";
    }
    @RequestMapping(path="/getdoc",method = RequestMethod.GET)
    public ResponseEntity<List<DoctorModel>> docdata(){
         return ResponseEntity.ok().body(doctorService.getdoctor());


    }
    @RequestMapping(path="/getpat",method = RequestMethod.GET)
    public ResponseEntity<List<PatientModel>> patdata(){
        return ResponseEntity.ok().body(patientService.getPatient());

    }



}

package hr.foi.air.ednevnik.Services;

import hr.foi.air.ednevnik.Entities.Specijalizant;
import hr.foi.air.ednevnik.Entities.Mentor;
import hr.foi.air.ednevnik.Repositories.MentorRepository;
import hr.foi.air.ednevnik.Repositories.SpecijalizantRepository;
import hr.foi.air.ednevnik.Requests.PrijavaRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin
@AllArgsConstructor
public class PrijavaService {

    private MentorRepository mentorRepository;
    private SpecijalizantRepository specijalizantRepository;
//    TODO: hashirati lozinku
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    TODO: instancirati token
//    private JwtTokenUtil jwtTokenUtil;

    public Specijalizant prijavaSpecijalizanta(PrijavaRequest request) throws Exception {

        List<Specijalizant> specijalizantList = specijalizantRepository.findAll();
        for (Specijalizant s : specijalizantList){
            //TODO: napraviti request za email i lozinku
            if(s.getEmail().equals(request.getEmail()) && s.getLozinka().equals(request.getLozinka())){
                return s;
            }
        }
        return null;

//        if (!bCryptPasswordEncoder.matches(lozinka, specijalizant.getLozinka())){
//            throw new Exception("Pogrešna lozinka!");
//        }
//        //TODO: generirati token
//        //String token = jwtTokenUtil.generateToken(specijalizant);
    }

    public Mentor prijavaMentora(PrijavaRequest request) throws Exception {

        List<Mentor> mentorList = mentorRepository.findAll();
        for (Mentor m : mentorList){
            //TODO: napraviti request za email i lozinku
            if(m.getEmail().equals(request.getEmail()) && m.getLozinka().equals(request.getLozinka())){
                return m;
            }
        }
        return null;

//        if (!bCryptPasswordEncoder.matches(lozinka, mentor.getLozinka())){
//            throw new Exception("Pogrešna lozinka!");
//        }
//        //TODO: generirati token
//        //String token = jwtTokenUtil.generateToken(mentor);
    }
}

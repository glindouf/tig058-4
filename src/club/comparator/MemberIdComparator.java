/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package club.comparator;

import club.domain.Member;
import java.util.Comparator;

/**
 *
 * @author phcr
 */
public class MemberIdComparator implements Comparator<Member> {

    @Override
    public int compare(Member m1, Member m2) {
       return m1.getId().compareTo(m2.getId());
    }
    
}

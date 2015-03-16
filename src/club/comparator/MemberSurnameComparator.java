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
 * @author jola
 */
public class MemberSurnameComparator implements Comparator<Member> {
    @Override
    public int compare(Member m1, Member m2) {
        if (m1.getSurname().equals(m2.getSurname())) {
            return m1.getGivenname().compareTo(m2.getGivenname());
        } else {
            return m1.getSurname().compareTo(m2.getSurname());
        }
    }
}

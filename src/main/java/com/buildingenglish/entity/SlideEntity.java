package com.buildingenglish.entity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Table(name = "slides")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@SQLDelete(sql = "UPDATE slides SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class SlideEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String image;
    private String text;
    @Column (name = "order_number")
    private Integer order;
    @ManyToOne
    @JoinColumn(name = "card")
    private CardEntity cardEntity;

    @Column(name="soft_delete")
    private Boolean softDelete = Boolean.FALSE;
}

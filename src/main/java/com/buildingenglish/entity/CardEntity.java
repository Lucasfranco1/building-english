package com.buildingenglish.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "card")
@SQLDelete(sql = "UPDATE card SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class CardEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;


    private String sentenceEnglish;
    private String sentencePronunciation;
    @NotNull
    private String sentenceSpanish;

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamps;

    @Column(name="soft_delete")
    private Boolean softDelete = Boolean.FALSE;
}

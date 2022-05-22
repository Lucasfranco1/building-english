package com.buildingenglish.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name = "vocabulary")
@SQLDelete(sql = "UPDATE vocabulary SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class VocabularyEntity{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String english;

    private String pronunciation;

    private String spanish;

    private String description;

    @Column(nullable = false,updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamps;

    @Column(name="soft_delete")
    private Boolean softDelete = Boolean.FALSE;
}

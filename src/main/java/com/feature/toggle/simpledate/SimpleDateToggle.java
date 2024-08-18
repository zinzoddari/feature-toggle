package com.feature.toggle.simpledate;

import com.feature.toggle.infra.orm.BooleanYnConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "SIMPLE_DATE_TOGGLE_INFO")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SimpleDateToggle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Comment("토글 ID")
    @Column(name = "TOGGLE_ID", length = 32)
    private String toggleId;

    @Comment("설명")
    @Column(name = "DESCRIPTION", length = 128)
    private String description;

    @Comment("토글 적용 시작 시간")
    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Comment("토글 적용 종료 시간")
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Comment("사용 여부")
    @Column(name = "USE_YN")
    @Convert(converter = BooleanYnConverter.class)
    private boolean useYn;
}

package com.feature.toggle.simplelocalcahce.toggle;

import com.feature.toggle.infra.orm.BooleanYnConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@Builder
@Table(name = "SIMPLE_CACHE_TOGGLE_INFO")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SimpleCacheToggle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Comment("토글 ID")
    @Column(name = "TOGGLE_ID", length = 32)
    private String toggleId;

    @Comment("설명")
    @Column(name = "DESCRIPTION", length = 128)
    private String description;

    @Comment("사용 여부")
    @Column(name = "USE_YN")
    @Convert(converter = BooleanYnConverter.class)
    private boolean useYn;

    public void changeUseYn() {
        if (useYn) {
            this.useYn = false;

            return;
        }

        this.useYn = true;
    }
}

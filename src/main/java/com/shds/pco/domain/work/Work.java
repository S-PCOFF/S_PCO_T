package com.shds.pco.domain.work;

import com.shds.pco.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// 클래스 내 모든 필드의 Getter 메소드 자동 생성
@Getter
// 기본 생성자 자동 추가
@NoArgsConstructor
// 테이블과 링크될 클래스임을 나타냄
@Entity
public class Work extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idx;

    @Column(length = 50, columnDefinition = "TEXT", nullable = false)
    private long id;

    @Column(length = 20, columnDefinition = "TEXT", nullable = false)
    private String name;

    @Column(length = 8, columnDefinition = "TEXT", nullable = false)
    private String workDate;

    @Column(length = 3)
    private int workMinute;

    // 해당 클래스의 빌더 패턴 클래스 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Work(long id, String name, String workDate, int workMinute) {
        this.id = id;
        this.name = name;
        this.workDate = workDate;
        this.workMinute = workMinute;
    }

    public void update(String name, String workDate, int workMinute) {
        this.name = name;
        this.workDate = workDate;
        this.workMinute = workMinute;
    }
}

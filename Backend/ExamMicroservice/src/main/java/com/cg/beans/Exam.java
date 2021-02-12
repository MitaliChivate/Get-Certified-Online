package com.cg.beans;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EXAM")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_id_sequence")
	@SequenceGenerator(name = "exam_id_sequence", initialValue = 300000, allocationSize = 1)
	private long examId;
	
	@Future
	private LocalDate examDate;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	@Size(min = 2, max = 20) 
	@NotBlank
	private String examName;
	@Min(100)
	@Max(9999)
	private Integer examCost;
	@Size(min = 2, max = 200) 
	@NotBlank
	private String description;
	@Min(1)
	@Max(120)
	private int  availableSeats;
}

package com.cg;
import org.junit.jupiter.api.Test;

import com.cg.beans.TrainingProgram;
import com.cg.service.TrainingProgramImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrainingTests {
	
	@Test
	public void addTest() {
		
		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);

		TrainingProgramImpl trainingService = mock(TrainingProgramImpl.class);

		when(trainingService.addTrainingProgram(trainingProgram1)).thenReturn(trainingProgram1);

		TrainingProgram trainingProgram2 = trainingService.addTrainingProgram(trainingProgram1);

		assertEquals(trainingProgram1, trainingProgram2);

	}

	

}

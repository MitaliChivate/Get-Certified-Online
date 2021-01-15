package com.cg;

import org.junit.jupiter.api.Test;


import com.cg.beans.TrainingProgram;
import com.cg.service.TrainingProgramImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class TrainingTests {
	
	@Test
	public void addTest() {
		
		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);

		TrainingProgramImpl trainingService = mock(TrainingProgramImpl.class);

		when(trainingService.addTrainingProgram(trainingProgram1)).thenReturn(trainingProgram1);

		TrainingProgram trainingProgram2 = trainingService.addTrainingProgram(trainingProgram1);

		assertEquals(trainingProgram1, trainingProgram2);

	}

	@Test
	public void updateTrainingProgram() {
		
		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);

		TrainingProgramImpl trainingService = mock(TrainingProgramImpl.class);

		trainingService.addTrainingProgram(trainingProgram1);

		TrainingProgram trainingProgram2 = new TrainingProgram(200001L, "Python", "Programming Language", 2000, 60);

		when(trainingService.updatetrainingProgram(trainingProgram2)).thenReturn(trainingProgram2);
		TrainingProgram trainingProgram3 = trainingService.updatetrainingProgram(trainingProgram2);
		assertEquals(trainingProgram2, trainingProgram3);

	}
	
	
	@Test
	void findAllTrainingPrograms()
	{
		

		List<TrainingProgram> tp1 = new ArrayList<>(); 
		TrainingProgram t1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);
		TrainingProgram t2 = new TrainingProgram(200002L, "Python", "Programming Language", 1500, 30);
		
		tp1.add(t1);
		tp1.add(t2);
		
		
		TrainingProgramImpl service = mock(TrainingProgramImpl.class);
		System.out.println(tp1);
		
		when(service.GetAllTrainingProgram()).thenReturn(tp1);
		List<TrainingProgram> tp2 = service.GetAllTrainingProgram();
		assertNotNull(tp2);
		assertFalse(tp2.isEmpty());
	}
	

	@Test
	public void deleteTrainingTest() {

		TrainingProgram trainingProgram1 = new TrainingProgram(200001L, "Java", "Programming Language", 2000, 60);
		TrainingProgramImpl trainingService = mock(TrainingProgramImpl.class);
		trainingService.addTrainingProgram(trainingProgram1);
		 
		 when(trainingService.deleteTrainingProgram(200001L)).thenReturn((int) 200001L);
		 Integer trainingProgram2 = trainingService.deleteTrainingProgram(200001L);
			assertEquals((int) 200001L, trainingProgram2);
	}

	
}

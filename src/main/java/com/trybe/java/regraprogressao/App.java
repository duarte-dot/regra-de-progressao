package com.trybe.java.regraprogressao;

import java.util.Scanner;

public class App {

  /**
   * Metodo main.
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Digite a quantidade de atividades para cadastrar:");
    int activityNumber = scanner.nextInt();
    scanner.nextLine();

    String[] activitiesNames = new String[activityNumber];
    int[] activitiesWeights = new int[activityNumber];
    int[] activitiesGrades = new int[activityNumber];

    for (int i = 0; i < activityNumber; i++) {
      System.out.println("Digite o nome da atividade " + (i + 1) + ":");
      String activityName = scanner.nextLine();
      activitiesNames[i] = activityName;

      System.out.println("Digite o peso da atividade " + (i + 1) + ":");
      int activityWeight = readIntFromUser(scanner);
      activitiesWeights[i] = activityWeight;

      System.out.println("Digite a nota obtida para " + activityName + ":");
      int activityGrade = readIntFromUser(scanner);
      activitiesGrades[i] = activityGrade;
    }

    scanner.close();

    double finalGrade = calculateFinalGrade(activitiesGrades, activitiesWeights);

    if (finalGrade >= PASSING_GRADE) {
      System.out.println(
              "Parabéns! Você alcançou "
              + finalGrade
              + "%! E temos o prazer de informar que você obteve aprovação!");
    } else {
      System.out.println(
              "Lamentamos informar que, com base na sua pontuação alcançada neste período, "
              + finalGrade
              + "%, você não atingiu a pontuação mínima necessária para sua aprovação.");
    }
  }

  private static final int PASSING_GRADE = 85;

  private static int readIntFromUser(Scanner scanner) {
    while (true) {
      try {
        return Integer.parseInt(scanner.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Por favor, digite um valor inteiro válido.");
      }
    }
  }

  private static double calculateFinalGrade(int[] grades, int[] weights) {
    double totalWeightedScore = 0.0;
    double totalWeight = 0.0;

    for (int i = 0; i < grades.length; i++) {
      totalWeightedScore += (grades[i] * weights[i]);
      totalWeight += weights[i];
    }

    return (totalWeightedScore / totalWeight);
  }
}
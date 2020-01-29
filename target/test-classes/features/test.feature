Feature: Login Feature
  @TestEscenario1
  Scenario Outline: User is able to search flight
    Given User is on page
    Then  flight section Selected
    Then  Search flight <from> - <to> on <date>
    Then  Verify results
    Then   Result values order

    Examples: 
      | from                                                                     | to                                 | date       |
      | "Mérida, Yucatán, México (MID-A. Internacional Manuel Crescencio Rejón)" | "Hermosillo, Sonora, México (HMO)" | 14/02/2020 |

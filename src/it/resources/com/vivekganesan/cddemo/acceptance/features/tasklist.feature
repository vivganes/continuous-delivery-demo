Feature: Task List
  Scenario: Empty Task List
    Given there are no tasks
    When i open the task list page
    Then i see a header welcoming me
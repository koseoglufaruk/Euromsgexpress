Feature: Create New List

  @wip
  Scenario: Add new members to List
    Given the user should already logged in with "testeuromessage@outlook.com" email and "Testtest.1" password
    When the user click Üyelerini Ekle
    And the user click Yeni Liste Oluştur
    And the user type list name as "TesList"
    And the user click Kaydet button
    And the user click Üye Ekle button
    And the user click Form ile Ekle option
    And the user enter following information click Kaydet button
      | Ad1      | test1            |
      | Soyad1   | test-1           |
      | E-Posta1 | test1-1@test.com |
      | Ad2      | test2            |
      | Soyad2   | test-2           |
      | E-Posta2 | test2-2@test.com |
      | Ad3      | test3            |
      | Soyad3   | test-3           |
      | E-Posta3 | test3-3@test.com |
    Then the user should display following informations in Kaydedilenler
      | Ad1      | test1            |
      | Soyad1   | test-1           |
      | E-Posta1 | test1-1@test.com |
      | Ad2      | test2            |
      | Soyad2   | test-2           |
      | E-Posta2 | test2-2@test.com |
      | Ad3      | test3            |
      | Soyad3   | test-3           |
      | E-Posta3 | test3-3@test.com |


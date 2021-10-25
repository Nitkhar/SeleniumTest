# language: ru

Функция: ПереходНаДругуюСТраницу

  @success
  Сценарий: ПереходНаСтраницуБезопасности
    Дано пользователь заходит на главную страницу Банка Санкт-Петербург
    Когда пользователь нажимает на пятую кнопку-переключатель
    И нажимает на большую голубую кнопку
    Тогда пользователь переходит на страницу Безопасность
    И закрывает браузер

  @success
  Сценарий: ПереходНаСтраницуПотребительскогоКредита
    Дано пользователь заходит на главную страницу Банка Санкт-Петербург
    Когда пользователь нажимает на кнопку Потребительский кредит в списке Кредиты
    Тогда пользователь заходит на страницу Потребительский кредит
    И закрывает браузер
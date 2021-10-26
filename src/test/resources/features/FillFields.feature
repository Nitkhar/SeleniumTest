# language: ru

Функция: ЗаполнениеПолей

  Структура сценария: ЗаполнениеЗаказаКарты
    Дано пользователь заходит на страницу заказа карты
    Когда пользователь заполняет поля данными:
      | Платежная система         | <paymentSystem> |
      | Фамилия                   | <secondName>    |
      | Имя                       | <name>          |
      | Отчество                  | <fatherName>    |
      | E-Mail                    | <email>         |
      | Номер мобильного телефона | <phone>         |
    Затем пользователь проверяет что данные в полях соответствуют требуемым:
      | Платежная система         | <paymentSystemCheck> |
      | Фамилия                   | <secondNameCheck>    |
      | Имя                       | <nameCheck>          |
      | Отчество                  | <fatherNameCheck>    |
      | Имя на карте              | <cardNameCheck>           |
      | E-Mail                    | <emailCheck>              |
      | Номер мобильного телефона | <phoneCheck>              |
    И закрывает браузер
    Примеры:
      | paymentSystem | secondName | name   | fatherName | email             | phone        | paymentSystemCheck | secondNameCheck | nameCheck | fatherNameCheck | cardNameCheck | emailCheck        | phoneCheck         |
      | Mastercard    | пример     | пример | пример     | example@yandex.ru | +77777777777 | Mastercard         | ПРИМЕР          | ПРИМЕР    | ПРИМЕР          | PRIMER PRIME  | example@yandex.ru | +7 (777) 777-77-77 |
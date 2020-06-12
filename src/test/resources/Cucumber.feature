#language: ru
Функционал: Вклад

  @all
  @RUB
  Сценарий: Расчет рублевого вклада

    Когда выбрано меню "Вклад":
    Когда выбирается валюта "Рубли":
    И вводится сумма депозита "300000":
    И выбран срок "9" месяцев:
    И вводится сумма пополнений "50000":
    И выбирается капитализация процентов:
    Тогда ожидаемые значения равны:

      | начислено %      | 18056.35     |
      | пополнение       | 400000.0     |
      | к снятию         | 718056.35    |



  @all
  @USD
  Сценарий: Расчет долларового вклада

    Когда выбрано меню "Вклад":
    Когда выбирается валюта "Доллары США":
    И вводится сумма депозита "500000":
    И выбран срок "9" месяцев:
    И вводится сумма пополнений "5000":
    И выбирается капитализация процентов:
    Тогда ожидаемые значения равны:

      | начислено %      | 1159.38     |
      | пополнение       | 40000.0     |
      | к снятию         | 541159.38   |
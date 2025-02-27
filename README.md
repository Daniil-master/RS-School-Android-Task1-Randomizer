# Android. Task Randomizer (2021)

:point_up: В первом практическом задании мы создадим рандомайзер, он же - генератор случайных чисел.


## Описание задания

Приложение состоит из двух экранов. На первом экране пользователь вводит диапазон чисел (целые, неотрицательные) и нажимает кнопку "Generate", на втором - пользователю показывается сгенерированный результат и кнопка "Back". После возвращения на первый экран, пользователь видит предыдущий результат. Пример:


<img alt="fragment 1" src="/img/randomizer.gif" width="250" height="500" />

Исходный код шаблона приложения вы можете найти в этом репозитории.

- склонируйте его на свои машины или форкните сразу на github
- дополните код так, чтобы приложение работало как ожидается
- как результат в вашем репозитории должен быть исходный код работающего приложения, соответствующий или частично соответствующий критериям задания
- внешний вид - на ваше усмотрение, можете оставить как есть или изменить на свой вкус 

Экраны представлены в виде двух Fragments. Вы должны организовать передачу данных между фрагментами. :point_up: Сделайте это через интерфейсы и Activity. 

:exclamation: Давайте код Activity писать на Java, а код Fragments - на Kotlin. Разумеется, можно писать только на :man: Kotlin или исключительно на :older_man: Java, но на многих реальных проектах, если им не один год, приходится работать с двумя языками.

Подумайте, почему к методам `newInstance(...)` добавлена аннотация `@JvmStatic`?

До дедлайна сделайте Submit задания через https://app.rs.school/


## Cross-checking

- Изучите требования к <a href="https://docs.rs.school/#/cross-check-flow?id=cross-check">cross-check</a>
- Форму для оценки задания по критериям ищите <a href="https://ziginsider.github.io/checklist/index.html">здесь</a>

Успехов!

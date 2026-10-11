# Scrapbook App

This app tracks scrapbook pages that I have made this year. The names of the pages are what gets
added to the list.

## Screens

- **Home** - On the home screen, the user can add scrapbook pages, see how many pages they've "
  created" (added to the list), and redirect themselves to two different pages.
- **List** - On the list screen, the user can see every scrapbook page they've added. They have the
  option to remove all of the pages, or remove one. If there are no pages, they have the option to
  redirect themselves back to the home page to add a page to their list.
- **About** - On the about screen, the user can read about the purpose of this app.

## Input Rules

| Input                                                            | What the app says                                                     |
|------------------------------------------------------------------|-----------------------------------------------------------------------|
| (empty)                                                          | The add button is greyed out and cannot be pushed                     |
| (An input over 40 characters)                                    | The input box doesn't allow for more than 40 characters to be inputed |
| "2025"                                                           | "A name can't be only numbers"                                        |
| (An input under 3 characters)                                    | "Too short - at least 3 characters"                                   |
| (An input that already exists                                    | " 'Page Name' is already on the list"                                 |
| (An input that already exists but with different capitalization) | " 'Page Name' is already on the list"                                 |

## How to Run

1. Clone this repo
2. Open the cloned folder in Android Studio
3. Wait for Gradle sync, then Run

## Known Limitations

There is no way of adding information or pictures about each scrapbook page at this point in the
development process. 
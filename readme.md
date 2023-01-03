# Library

<mark>This repository is published under the [GPL3 license](https://www.gnu.org/licenses/gpl-3.0.en.html). Meaning you can copy, modify and reproduce as long as it remains open source and the original [owner](https://github.com/rapando) and the [source](https://github.com/rapando/library) is acknowledged. </mark>

Refer to the [summary](https://tldrlegal.com/license/gnu-general-public-license-v3-(gpl-3)) or read the whole [license](./LICENSE) file first.

---

This is a REST service for a library.

It does the following,
- saving, borrowing and returning books
- authenticates & authorizes users when accessing specific endpoints.
- caches some endpoints and some data
- publishes some data to a messaging queue e.g. in order to send notifications. The consumer will be a separate Java app.

---

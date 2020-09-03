# hadron

A small (and slow) language for physics calculations.

## Installation

You must have [Java](https://www.java.com/en/) and a recent version of [Gradle](https://gradle.org/) installed.

Clone this repo in a permanent location, then build it. The `gradle` command may take a while.

```bash
git clone git@github.com:JoelCourtney/hadron.git
cd hadron
gradle hadron
```

Link the `hadron` executable to somewhere in your path, or add the repo to your path.

Lastly, create the `$HADRON_ROOT` environment variable, pointing to the `hadron` repo (NOT the `hadron` script). You can also put this in your shell rc file.

```bash
export HADRON_ROOT="/LOCATION/OF/hadron"
```

## Usage

There is currently no REPL mode :(. Write a hadron file (for example `example.hn`), and run it with:

```bash
hadron example.hn
```

You can also make a hadron executable file with a typical shabang:

```kotlin
#! /usr/bin/env hadron

println("Hello World!")
```

## Syntax

I really don't want to do that right now.

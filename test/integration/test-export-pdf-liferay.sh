#!/bin/sh
mvn verify -P selenium,liferay -Dit.test=\*Export\*

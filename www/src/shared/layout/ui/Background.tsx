'use client'

import {PropsWithChildren} from "react";
import {Box} from "@mui/system";

export const Background = ({ children }: PropsWithChildren) => (
  <Box
    component={"section"}
    className={"flex flex-col items-center self-center bg-white lg:rounded-md lg:max-w-5xl rounded-none w-screen flex-1"}
    >
    {children}
  </Box>
)
